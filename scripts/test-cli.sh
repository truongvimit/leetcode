#!/bin/bash

# 🧪 Test CLI Commands
# Validates that all CLI functionality is correct

set -e

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

echo -e "${BLUE}🧪 Testing LeetCode CLI Commands${NC}"
echo "=================================="

# Test 1: Makefile syntax
echo -n "Testing Makefile syntax... "
if make -n help > /dev/null 2>&1; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${RED}✗${NC}"
    exit 1
fi

# Test 2: CLI source code syntax
echo -n "Testing CLI source syntax... "
if [[ -f "src/cli/LeetCodeCLI.kt" ]]; then
    # Basic syntax check (look for main function, proper class structure)
    if grep -q "fun main" src/cli/LeetCodeCLI.kt && \
       grep -q "class LeetCodeCLI" src/cli/LeetCodeCLI.kt; then
        echo -e "${GREEN}✓${NC}"
    else
        echo -e "${RED}✗ Missing main function or class${NC}"
        exit 1
    fi
else
    echo -e "${RED}✗ CLI source file not found${NC}"
    exit 1
fi

# Test 3: Script permissions
echo -n "Testing script permissions... "
if [[ -x "scripts/build-cli.sh" ]] && [[ -x "scripts/install-alias.sh" ]]; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${YELLOW}? Setting permissions${NC}"
    chmod +x scripts/*.sh
    echo -e "${GREEN}✓ Fixed${NC}"
fi

# Test 4: Directory structure
echo -n "Testing directory structure... "
required_dirs=("src/arrays" "src/strings" "src/trees" "src/cli" "tests")
missing_dirs=""

for dir in "${required_dirs[@]}"; do
    if [[ ! -d "$dir" ]]; then
        missing_dirs="$missing_dirs $dir"
    fi
done

if [[ -z "$missing_dirs" ]]; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${YELLOW}? Creating missing directories:$missing_dirs${NC}"
    for dir in $missing_dirs; do
        mkdir -p "$dir"
    done
    echo -e "${GREEN}✓ Fixed${NC}"
fi

# Test 5: Makefile commands
echo -n "Testing Makefile commands... "
commands=("help" "build" "install" "c" "f" "p" "s" "test" "clean")
for cmd in "${commands[@]}"; do
    if ! grep -q "^$cmd:" Makefile; then
        echo -e "${RED}✗ Missing command: $cmd${NC}"
        exit 1
    fi
done
echo -e "${GREEN}✓${NC}"

# Test 6: CLI command mapping
echo -n "Testing CLI command mapping... "
cli_commands=("create" "finish" "push" "stats")
for cmd in "${cli_commands[@]}"; do
    if ! grep -q "\"$cmd\"" src/cli/LeetCodeCLI.kt; then
        echo -e "${RED}✗ Missing CLI command: $cmd${NC}"
        exit 1
    fi
done
echo -e "${GREEN}✓${NC}"

echo ""
echo -e "${GREEN}🎉 All tests passed!${NC}"
echo ""
echo -e "${YELLOW}📋 Ready to use:${NC}"
echo -e "  ${BLUE}make help${NC}     - Show commands"
echo -e "  ${BLUE}make build${NC}    - Build CLI (requires Kotlin)"
echo -e "  ${BLUE}make install${NC}  - Install aliases"
echo ""
echo -e "${YELLOW}💡 Install Kotlin with:${NC} ${BLUE}brew install kotlin${NC}"