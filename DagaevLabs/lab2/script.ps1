# Check if the first argument is provided
if (-not $args[0]) {
    Write-Output "Using: $PSCommandPath"
    Write-Output "Enter word"
    exit 1
}

# Check if the second argument is provided
if ($args[1]) {
    Write-Output "Extra parameters found"
    exit 1
}

# Check if the dictionary file exists
if (-not (Test-Path "bd.txt")) {
    Write-Output "Error: the dictionary file does not exist"
    exit 1
}

# Search for the word in the dictionary file
$OUT = Select-String -Pattern $args[0] -Path "bd.txt" | Select-Object -First 1 | ForEach-Object { $_.Line -replace "$args[0] " }

# If the word is found in the dictionary
if ($OUT) {
    Write-Output "This is: $OUT"
    exit 0
}
else {
    $yn = Read-Host -Prompt "Word wasn't found, wanna add it to the dictionary? [y/n]"
    switch ($yn.ToLower()) {
        'y' {
            Write-Output ""
            break
        }
        'n' {
            Write-Output ""
            exit 0
        }
        default {
            Write-Output ""
            exit 1
        }
    }
    
    $partOfSpeech = Read-Host -Prompt "Enter part of speech for this word"
    $result = "$($args[0]) $($partOfSpeech)"
    Add-Content -Path "bd.txt" -Value $result
    exit 0
}