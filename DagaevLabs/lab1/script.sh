#!/bin/sh

if [ ! -n "$1" ]
then
echo "Использование: $0"
echo "Введите слово"
exit 1
fi

if [ -n "$2" ]
then
echo "Лишинй параметр"
exit 1
fi

if [ ! -n "bd.txt" ]
then
echo "Ошибка: отсутствует словарь"
exit 1
fi

OUT=$(grep --max-count=1 -w "$1" bd.txt | sed "s/$1 //")

if [ -n "$OUT" ]
then
echo "Это: $OUT"
exit 0
else
read -n 1 -p "Такого слова нет в словаре, хотите добавить? [y/n]" yn
case $yn in
    [Yy]* ) echo ""; break;;
    [Nn]* ) echo ""; exit 0;;
    * ) echo ""; exit 1;;
esac
echo "Введите часть речи данного слова"
read partOfSpeech
result="${1} ${partOfSpeech}"
echo "$result" >> bd.txt
exit 0
fi
exit 1
fi