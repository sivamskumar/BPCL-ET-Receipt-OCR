Write-Host ""
Write-Host "==========================================" -ForegroundColor Cyan
Write-Host " BPCL ET Receipt OCR - Project Bootstrap" -ForegroundColor Green
Write-Host "==========================================" -ForegroundColor Cyan
Write-Host ""

$folders = @(
    "docs",
    "config",
    "images",
    "logs",
    "reports",
    "tessdata",

    "src/main/java/com/bpcl/ocr",

    "src/main/java/com/bpcl/ocr/config",
    "src/main/java/com/bpcl/ocr/constants",
    "src/main/java/com/bpcl/ocr/exception",
    "src/main/java/com/bpcl/ocr/model",
    "src/main/java/com/bpcl/ocr/image",
    "src/main/java/com/bpcl/ocr/ocr",
    "src/main/java/com/bpcl/ocr/parser",
    "src/main/java/com/bpcl/ocr/compare",
    "src/main/java/com/bpcl/ocr/report",
    "src/main/java/com/bpcl/ocr/service",
    "src/main/java/com/bpcl/ocr/ui",
    "src/main/java/com/bpcl/ocr/util",

    "src/main/resources",

    "src/test/java/com/bpcl/ocr",
    "src/test/resources"
)

foreach ($folder in $folders) {

    if (!(Test-Path $folder)) {

        New-Item -ItemType Directory -Path $folder | Out-Null
        Write-Host "Created : $folder" -ForegroundColor Green

    }
    else {

        Write-Host "Exists  : $folder" -ForegroundColor Yellow

    }
}

Write-Host ""
Write-Host "Project directory structure created successfully." -ForegroundColor Green
Write-Host ""