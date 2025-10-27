# 🚀 LeetCode Solutions

> Tạo file → Code → Test → Debug → Push. Organized & Runnable.

## ⚡ Cách dùng

```bash
make new      # Tạo file problem mới (có package structure)
# [Code solution của bạn]
make test     # Test bằng problem number
make push     # Đẩy lên GitHub
```

## 📝 Ví dụ

```bash
make new
# Problem number: 2
# Problem name: AddTwoNumbers
# Category: linkedlists
# Difficulty: medium
# ✅ Created: src/linkedlists/medium/Problem002_AddTwoNumbers.kt

# [Bạn code solution với IntelliJ debug support]

make test
# Problem number: 2
# 🧪 Running src/linkedlists/medium/Problem002_AddTwoNumbers.kt...
# === Problem 2: AddTwoNumbers ===
# ✅ Tests completed!

make push  
# 🎉 Pushed to GitHub!
```

## 📁 Structure

```
src/
├── arrays/
│   ├── easy/Problem001_TwoSum.kt
│   └── medium/Problem015_ThreeSum.kt
├── linkedlists/
│   └── medium/Problem002_AddTwoNumbers.kt
├── trees/
│   └── easy/Problem104_MaxDepth.kt
└── strings/
    └── medium/Problem003_LongestSubstring.kt
```

## 🧪 Features

- **Package structure** cho IntelliJ IDEA
- **Debug support** trực tiếp trong IDE
- **Individual runnable** mỗi problem
- **Auto file naming** Problem001_TwoSum.kt
- **Clean Kotlin code** theo conventions

## 🚀 Commands

```bash
make new      # Tạo problem mới
make test     # Run by number (finds auto)
make run      # Run by full path  
make push     # Push to GitHub
make clean    # Clean temp files
```

**Perfect cho debug và development!** 🔥