# 📦 CHALLENGE: SISTEM DISTRIBUSI GUDANG

**Program:** Java Development Training Batch 17 (JDT-17)  
**Topik:** Spring Framework Dasar - Configuration, Bean & Dependency Injection  
**Tanggal:** 4 Juni 2026

---

## 📋 DESKRIPSI SOAL

Anda memiliki **1 Gudang** dan **5 Sales** yang bertugas mendistribusikan barang ke **pengepul** dan **toko pinggir jalan**.

Buatkan sistem perencanaan distribusi menggunakan konsep:
- Spring `@Configuration` & `@Bean`
- **Dependency Injection**
- **@Qualifier** (Mirroring Class Injection)

---

## 🏗️ KONSEP ARSITEKTUR

```
┌─────────────────────────────────────────────────┐
│                   GUDANG UTAMA                   │
│                  (Stok: 1000)                    │
└────────────┬────────────────────────┬───────────┘
             │                        │
    ┌────────▼────────┐     ┌────────▼────────┐
    │   SALES MOTOR   │     │   SALES MOBIL   │
    │  (Toko Pinggir) │     │   (Pengepul)    │
    └────────┬────────┘     └────────┬────────┘
             │                        │
     ┌───────┼───────┐          ┌────┼────┐
     │       │       │          │         │
   Andi    Budi    Cici       Dedi      Eka
  Zona A  Zona B  Zona C    Zona D    Zona E
```

---

## ✅ TUGAS YANG HARUS DIKERJAKAN

### Tugas 1: Buat Model `Gudang`
- Buat **record** atau **class** `Gudang`
- Field: `namaGudang` (String), `stokBarang` (int)

### Tugas 2: Buat Interface `Sales`
- Method yang wajib ada:
  - `String getNama()`
  - `String getWilayah()`
  - `String getTipeKendaraan()`

### Tugas 3: Buat 2 Implementasi Sales
| Class | Tipe | Target Distribusi |
|-------|------|-------------------|
| `SalesMotor` | Motor | Toko pinggir jalan (radius kecil) |
| `SalesMobil` | Mobil | Pengepul besar (radius besar) |

### Tugas 4: Buat `GudangConfiguration`
- Annotation: `@Configuration`
- Bean: `Gudang` → singleton, nama "Gudang Utama", stok awal **1000**

### Tugas 5: Buat `SalesConfiguration`
- Annotation: `@Configuration`
- Buat **5 Bean** Sales dengan `@Qualifier` berbeda:

| Bean | Qualifier | Class | Nama | Wilayah |
|------|-----------|-------|------|---------|
| 1 | `"motor1"` | SalesMotor | Andi | Zona A |
| 2 | `"motor2"` | SalesMotor | Budi | Zona B |
| 3 | `"motor3"` | SalesMotor | Cici | Zona C |
| 4 | `"mobil1"` | SalesMobil | Dedi | Zona D |
| 5 | `"mobil2"` | SalesMobil | Eka  | Zona E |

### Tugas 6: Buat `DistribusiService`
- Inject **1 Gudang** (single injection)
- Inject **5 Sales** menggunakan `@Qualifier` (multiple/double injection)
- Buat method `distribusiBarang()` yang mencetak info distribusi setiap sales

### Tugas 7: Buat `DistribusiConfiguration`
- Wiring semua bean (Gudang + Sales + DistribusiService)

### Tugas 8: Jalankan di `Application.java`
- Load context dari `DistribusiConfiguration`
- Panggil `distribusiBarang()`

---

## 📤 EXPECTED OUTPUT

```
[DISTRIBUSI] Sales: Andi | Wilayah: Zona A | Kendaraan: Motor | Gudang: Gudang Utama (stok: 1000)
[DISTRIBUSI] Sales: Budi | Wilayah: Zona B | Kendaraan: Motor | Gudang: Gudang Utama (stok: 1000)
[DISTRIBUSI] Sales: Cici | Wilayah: Zona C | Kendaraan: Motor | Gudang: Gudang Utama (stok: 1000)
[DISTRIBUSI] Sales: Dedi | Wilayah: Zona D | Kendaraan: Mobil | Gudang: Gudang Utama (stok: 1000)
[DISTRIBUSI] Sales: Eka  | Wilayah: Zona E | Kendaraan: Mobil | Gudang: Gudang Utama (stok: 1000)
```

---

## 💡 HINTS

1. `Gudang` cukup 1 bean saja (shared/singleton ke semua Sales)
2. `Sales` ada 5 bean — karena interface sama, Spring butuh `@Qualifier` untuk membedakan
3. `DistribusiService` constructor menerima Gudang + 5 parameter Sales yang di-qualify
4. Lihat contoh `@Qualifier` di Spring documentation

---

## 🌟 BONUS (Opsional)

- Tambahkan logic **pengurangan stok** setiap kali sales distribusi (misal: **-50 per sales**)
- Print **sisa stok** setelah semua sales selesai distribusi

**Expected Bonus Output:**
```
[DISTRIBUSI] Sales: Andi | Wilayah: Zona A | Kendaraan: Motor | Gudang: Gudang Utama (stok: 950)
[DISTRIBUSI] Sales: Budi | Wilayah: Zona B | Kendaraan: Motor | Gudang: Gudang Utama (stok: 900)
[DISTRIBUSI] Sales: Cici | Wilayah: Zona C | Kendaraan: Motor | Gudang: Gudang Utama (stok: 850)
[DISTRIBUSI] Sales: Dedi | Wilayah: Zona D | Kendaraan: Mobil | Gudang: Gudang Utama (stok: 800)
[DISTRIBUSI] Sales: Eka  | Wilayah: Zona E | Kendaraan: Mobil | Gudang: Gudang Utama (stok: 750)

[SISA STOK] Gudang Utama: 750 unit
```

---

## 📂 STRUKTUR FILE YANG DIHARAPKAN

```
src/main/java/com/indivaragroup/jdt17/spring/dasar/
├── exam/
│   ├── model/
│   │   └── Gudang.java
│   ├── service/
│   │   ├── Sales.java (interface)
│   │   ├── SalesMotor.java
│   │   └── SalesMobil.java
│   ├── configuration/
│   │   ├── GudangConfiguration.java
│   │   ├── SalesConfiguration.java
│   │   └── DistribusiConfiguration.java
│   └── DistribusiService.java
└── Application.java
```

---

## 🎯 LEARNING OBJECTIVES

Setelah mengerjakan challenge ini, Anda diharapkan memahami:

1. **@Configuration** — Cara mendefinisikan class sebagai sumber bean
2. **@Bean** — Cara membuat object yang dimanage Spring Container
3. **Dependency Injection** — Spring yang inject dependency, bukan kita manual `new`
4. **@Qualifier** — Cara membedakan multiple bean dengan tipe/interface yang sama
5. **Singleton Bean** — Satu instance Gudang dipakai bersama oleh semua Sales

---

*Selamat mengerjakan! 🚀*
