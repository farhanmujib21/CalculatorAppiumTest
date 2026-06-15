# Calculator Appium Test

Project automation testing untuk aplikasi mobile **Calculator** menggunakan **Appium** dan **Java** (TestNG). Project ini dibuat sebagai tugas mata kuliah Konstruksi Perangkat Lunak (KPL).

## 📱 Tentang Aplikasi yang Ditest

Aplikasi yang diuji adalah **Calculator App** (scientific calculator sederhana) berbasis Android, dibangun menggunakan Java di Android Studio.

- **Package**: `com.example.calculator`
- **Main Activity**: `com.example.calculator.MainActivity`
- File APK tersedia di folder [`apk/`](./apk)

## 🛠️ Tech Stack

- **Appium** v3.5.0 (UiAutomator2 Driver)
- **Java** 21 (Eclipse Temurin)
- **Maven** (build tool & dependency management)
- **TestNG** (testing framework)
- **Selenium Java** 4.27.0
- **Appium Java Client** 9.5.0
- **Android Emulator** (Pixel - Android 13 / API 33)

## 📁 Struktur Project

```
CalculatorAppiumTest/
├── apk/
│   └── Calculator.apk          # APK aplikasi yang ditest
├── src/
│   └── test/java/com/usk/calculator/
│       ├── BaseTest.java        # Setup koneksi Appium Driver
│       └── CalculatorTest.java  # Test script (5 test case)
├── pom.xml                       # Konfigurasi Maven & dependencies
├── testng.xml                    # Konfigurasi TestNG suite
└── .gitignore
```

## ✅ Test Case

| ID | Title | Test Steps | Test Data | Expected Result |
|----|-------|------------|-----------|------------------|
| TC01 | Addition | Tap 2 → tap + → tap 3 → tap = | 2 + 3 | Hasil = 5 |
| TC02 | Subtraction | Tap 9 → tap - → tap 4 → tap = | 9 - 4 | Hasil = 5 |
| TC03 | Multiplication | Tap 6 → tap × → tap 7 → tap = | 6 × 7 | Hasil = 42 |
| TC04 | Division | Tap 8 → tap ÷ → tap 2 → tap = | 8 ÷ 2 | Hasil = 4 |
| TC05 | Clear Button | Tap 5 → tap C | - | Display kembali kosong/0 |

**Hasil eksekusi**: 5/5 test PASS ✅

## ⚙️ Cara Menjalankan

### Prasyarat
1. **Java JDK 21** sudah terinstall
2. **Android Studio** + Android SDK (set `ANDROID_HOME`)
3. **Node.js** + **Appium Server** (`npm install -g appium`)
4. Driver **UiAutomator2** (`appium driver install uiautomator2`)
5. **Maven** sudah terinstall
6. **Android Emulator** sudah running (`adb devices` menampilkan device dengan status `device`)

### Langkah Eksekusi

1. Install APK ke emulator:
   ```bash
   adb install apk/Calculator.apk
   ```

2. Jalankan Appium server (di terminal terpisah):
   ```bash
   appium
   ```

3. Jalankan test:
   ```bash
   mvn clean test
   ```

4. Hasil test dapat dilihat di terminal dan di folder `target/surefire-reports/`

## 📋 Resource ID Elemen Aplikasi

| Elemen | Resource ID |
|--------|-------------|
| Display hasil | `tvmain` |
| Display ekspresi | `tvsec` |
| Tombol 0-9 | `b0` - `b9` |
| Tombol `+` | `bplus` |
| Tombol `-` | `bminus` |
| Tombol `×` | `bmod` |
| Tombol `÷` | `bdiv` |
| Tombol `=` | `bequal` |
| Tombol `.` | `bdot` |
| Tombol `AC` | `bac` |
| Tombol `C` | `bc` |

## 👤 Author
Nama: Farhan Mujiburrahman
Mata Kuliah: Kualitas Perangkat Lunak (KPL)
Semester 6 - Informatika
