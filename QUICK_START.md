# 🚀 Quick Start Guide - LeetCode CLI Tool

**Get productive in under 2 minutes!**

## ⚡ Super Quick Setup (30 seconds)

```bash
# 1️⃣ Clone and enter
git clone https://github.com/truongvimit/leetcode.git && cd leetcode

# 2️⃣ One-command setup (installs everything!)
make setup-dev

# 3️⃣ Restart terminal, then use anywhere!
leetcode help
```

## 🎯 Essential Commands

### 📝 Create New Problem

```bash
# Creates solution + test templates, opens in IDE
leetcode create 002 AddTwoNumbers linkedlists medium

# Or interactive mode
make workflow-new
```

### 🎉 Complete Workflow (The Magic Command!)

```bash
# Does EVERYTHING: tests → commits → pushes → updates progress
leetcode complete 002 "Optimal carry handling solution"
```

### 📊 Check Progress

```bash
# Beautiful stats dashboard
leetcode stats

# Quick info
make info
```

## 🛠️ Advanced Usage

### 🔄 Step-by-Step Workflow

```bash
# Create problem
leetcode create 003 LongestSubstring strings medium

# Code your solution in the generated files...

# Test solution
leetcode test 003

# Commit when ready
leetcode commit 003 "Sliding window approach"

# Push to GitHub
leetcode push
```

### 📈 Daily Routine

```bash
# Your daily LeetCode ritual
make daily
# Shows stats + updates progress + motivational message!
```

## 🎯 Real Example Walkthrough

```bash
# 1️⃣ Setup (first time only)
make setup-dev

# 2️⃣ Create problem
leetcode create 002 AddTwoNumbers linkedlists medium

# 3️⃣ Code in the generated files:
# - src/linkedlists/medium/Problem002_AddTwoNumbers.kt
# - tests/Problem002_AddTwoNumbersTest.kt

# 4️⃣ Complete submission
leetcode complete 002 "Iterative solution with carry handling"

# 🎉 Done! Auto-committed and pushed to GitHub with professional message
```

## 🚨 Troubleshooting

### Missing Dependencies?

```bash
# Check what's missing
make check-deps

# Install Kotlin if needed
brew install kotlin

# Or manual install from: https://kotlinlang.org/docs/command-line.html
```

### CLI Not Found?

```bash
# Build manually
make build

# Install global alias
make install

# Restart terminal
source ~/.zshrc  # or ~/.bashrc
```

### Build Issues?

```bash
# Clean and rebuild
make clean
make build

# Check Java version (needs 11+)
java --version
```

## 🔥 Pro Tips

### 💡 Shortcuts

```bash
# Use Makefile for convenience
make complete PROBLEM=002           # Instead of leetcode complete
make create PROBLEM=003,Name,cat,diff
make stats                          # Quick stats
```

### 🎨 Customization

- Edit `src/cli/LeetCodeCLI.kt` to modify templates
- Update `Makefile` to add custom commands
- Modify `.github/workflows/` for automation tweaks

### 📱 IDE Integration

The CLI automatically tries to open files in:

1. IntelliJ IDEA (`idea` command)
2. VS Code (`code` command)
3. Sublime Text (`subl` command)
4. Atom (`atom` command)

## 🎓 Example Commands You'll Love

```bash
# Interactive problem creation
make workflow-new

# Complete submission workflow  
make workflow-submit

# Daily routine with stats
make daily

# Push with confirmation
make push

# Clean slate
make clean

# Project overview
make info

# Help anytime
make help
leetcode help
```

## 🌟 What Makes This Special?

### ✨ **Unique Features**

- **First CLI tool** for LeetCode with complete automation
- **Professional commit messages** with metadata
- **Auto-progress tracking** in README
- **GitHub Actions integration** for CI/CD
- **Template generation** with TODO markers
- **Statistical dashboard** with beautiful output

### 🚀 **Productivity Boost**

- **5x faster** problem creation vs manual setup
- **Zero errors** in file structure and naming
- **Professional workflow** from day one
- **Consistent coding style** across all solutions
- **Automated testing** and validation

### 💪 **Interview Ready**

- **Pattern-based organization** mirrors interview prep
- **Time complexity analysis** templates
- **Edge case testing** built-in
- **Clean documentation** impresses recruiters
- **GitHub portfolio** showcases professionalism

---

## 🎉 You're Ready!

Start with:

```bash
make setup-dev
leetcode create 002 AddTwoNumbers linkedlists medium
```

Then code, test, and:

```bash
leetcode complete 002 "Your awesome solution description"
```

**Happy coding! 🚀**

---

*Need help? Check the [full README](README.md) or [contributing guide](CONTRIBUTING.md)*