<?php
$timestamp = date('dmYHis');  // это у нас будет номер заказа 
// $pre_order - это сумма, которую надо заплатить. Берётся из формы. 
$pre_order = str_replace(' ', '', $pre_order); // Надо убрать пробел разделяющий разряды (ну типа 1 000 -> 1000)
$pre_order = $pre_order*100; // и умножить на сто, т.к. в запросе в банк надо указывать сумму в копейках.
        
// Отправляем запрос в банк
$myCurl = curl_init();
curl_setopt_array($myCurl, array(
    CURLOPT_URL => 'https://securepayments.sberbank.ru/payment/rest/register.do?userName=XXXXXXXXXXXXX-api&password=XXXXXXXXXXXXX&amount='.$pre_order.'&language=ru&orderNumber='.$timestamp.'&returnUrl=https://yoursite.com/send',   
// Вот эта строка и есть запрос в банк. Тут нужно указать только свой userName, password, сумму и номер заказа, а так же returnUrl= адрес страницы куда мы вернёмся после оплаты. 
// Сюда же можно добавить &jsonParams= {"Имя":"Параметр"}, о котором я писал выше. Но это такое...
// Вообще в справке там много всяких доп. параметров описано, но я там ничего особо полезного не нашёл.  
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_POST => true,
    CURLOPT_POSTFIELDS => http_build_query(array(''))
));
$response = curl_exec($myCurl);
curl_close($myCurl);
// Всё. Запрос отправлен. В ответ мы получаем строку с ID заказа и ссылкой на оплату.
// Если выполнить echo $response, то можно эту строку увидеть.
// Теперь нам надо из этой строки, полученной в ответ от банка, получить отдельно ID заказа, отдельно ссылку на оплату
// Обрезаем ответ, чтобы получить url
$url = strstr($response, 'https:');
$url = strstr($url, '"', true);
// Обрезаем ответ, чтобы получить id заказа
$orderid = strstr($response, '","formUrl"', true);
$orderid = mb_substr($orderid, 12); 

// Создаём файл с именем = id заказа. Именно так, потому что потом мы по этому id этот файл и будем находить.
$myfile='../orders/'.$orderid.'.txt';   
 
// Заполняем его данными из формы
$text .= $familiya.";";
$text .= $imya.";";
$text .= $otchestvo.";";
$text .= $tel.";";
$text .= $email.";";
$text .= $city.";";
$text .= $course_info.";";
$text .= $price.";";
$text .= $pre_order."";
    
$file=fopen($myfile,'x+');
fputs($file,$text);
fclose($file);
    
// Переходим на страницу оплаты. $url мы получили из ответа от банка
header('Location: '.$url);
?>