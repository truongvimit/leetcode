package cli

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * LeetCode CLI - Minimalist Pro Workflow
 */
class LeetCodeCLI {

    companion object {
        const val RESET = "\u001B[0m"
        const val RED = "\u001B[31m"
        const val GREEN = "\u001B[32m"
        const val CYAN = "\u001B[36m"
        const val DIM = "\u001B[2m"
    }

    private val categories = listOf(
        "arrays", "strings", "hashmaps", "linkedlists", "trees", "graphs",
        "dynamicprogramming", "backtracking", "sorting", "binarysearch",
        "slidingwindow", "twopointers", "greedy", "heaps", "stacks", "queues"
    )

    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            printHelp(); return
        }

        when (args[0]) {
            "create", "c" -> createProblem(args)
            "finish", "f" -> finishProblem(args)
            "push", "p" -> quickPush()
            "stats", "s" -> quickStats()
            else -> println("${RED}Unknown. Use: create|finish|push|stats${RESET}")
        }
    }

    private fun createProblem(args: Array<String>) {
        if (args.size < 4) {
            println("${RED}Usage: c <num> <name> <category> [difficulty]${RESET}")
            return
        }

        val (num, name, category) = Triple(
            args[1].padStart(3, '0'),
            args[2],
            args[3]
        )
        val difficulty = if (args.size > 4) args[4] else "medium"

        if (!categories.contains(category)) {
            println("${RED}Invalid category${RESET}")
            return
        }

        createFiles(num, name, category, difficulty)
        println("${GREEN}✓${RESET} Problem$num$name ${DIM}created${RESET}")
    }

    private fun createFiles(num: String, name: String, category: String, difficulty: String) {
        // Minimal solution template
        val solutionDir = File("src/$category/$difficulty").apply { mkdirs() }
        File("${solutionDir.path}/Problem${num}_${name}.kt").writeText(
            """/**
 * $num: $name | ${difficulty.capitalize()}
 * Time: O(?), Space: O(?)
 */
package $category.$difficulty

class Problem${num}_${name} {
    fun solve(): Unit = TODO()
}
"""
        )

        // Minimal test template
        File("tests/Problem${num}_${name}Test.kt").writeText(
            """import $category.$difficulty.Problem${num}_${name}

class Problem${num}_${name}Test {
    private val solution = Problem${num}_${name}()
    
    fun test() {
        // TODO: Add tests
        println("✓ Problem $num tests pass")
    }
}

fun main() = Problem${num}_${name}Test().test()
"""
        )
    }

    private fun finishProblem(args: Array<String>) {
        if (args.size < 2) {
            println("${RED}Usage: f <num> [message]${RESET}")
            return
        }

        val num = args[1].padStart(3, '0')
        val message = if (args.size > 2) args.drop(2).joinToString(" ") else detectSolutionType(num)

        // Quick workflow: test → commit → push
        print("${DIM}Testing...${RESET}")
        if (!runQuickTest(num)) return

        print(" ${DIM}Committing...${RESET}")
        val commitMsg = "✨ Problem $num: $message"
        if (!executeCommand("git add . && git commit -m \"$commitMsg\"").success) {
            println(" ${RED}✗ Commit failed${RESET}")
            return
        }

        print(" ${DIM}Pushing...${RESET}")
        if (executeCommand("git push").success) {
            println(" ${GREEN}✓ Done${RESET}")
        } else {
            println(" ${RED}✗ Push failed${RESET}")
        }
    }

    private fun quickPush() {
        val result = executeCommand("git add . && git commit -m \"🚀 Update\" && git push")
        println(if (result.success) "${GREEN}✓ Pushed${RESET}" else "${RED}✗ Failed${RESET}")
    }

    private fun quickStats() {
        val total = categories.sumOf { category ->
            listOf("easy", "medium", "hard").sumOf { difficulty ->
                File("src/$category/$difficulty").listFiles()?.count { it.extension == "kt" } ?: 0
            }
        }
        println("${GREEN}$total${RESET} ${DIM}problems solved${RESET}")
    }

    private fun detectSolutionType(num: String): String {
        // Smart detection based on file content
        val files = File("src").walk().filter {
            it.name.contains("Problem$num") && it.extension == "kt"
        }.toList()

        if (files.isEmpty()) return "Solution"

        val content = files.first().readText()
        return when {
            content.contains("HashMap") || content.contains("Map") -> "HashMap approach"
            content.contains("dp") || content.contains("Dynamic") -> "DP solution"
            content.contains("two") && content.contains("pointer") -> "Two pointers"
            content.contains("binary") && content.contains("search") -> "Binary search"
            content.contains("sliding") && content.contains("window") -> "Sliding window"
            else -> "Optimal solution"
        }
    }

    private fun runQuickTest(num: String): Boolean {
        val result = executeCommand("kotlinc -cp . tests/*$num*.kt -include-runtime -d temp.jar && java -jar temp.jar")
        executeCommand("rm -f temp.jar")
        return result.success
    }

    private fun executeCommand(command: String): CommandResult {
        return try {
            val process = ProcessBuilder("sh", "-c", command).start()
            CommandResult(process.waitFor() == 0, "")
        } catch (e: Exception) {
            CommandResult(false, e.message ?: "")
        }
    }

    private fun printHelp() {
        println("${CYAN}LeetCode CLI Pro${RESET}")
        println("c <num> <name> <category> [diff] ${DIM}- Create problem${RESET}")
        println("f <num> [msg]                    ${DIM}- Finish & auto-push${RESET}")
        println("p                                ${DIM}- Quick push${RESET}")
        println("s                                ${DIM}- Show stats${RESET}")
    }

    data class CommandResult(val success: Boolean, val output: String)
}

fun main(args: Array<String>) = LeetCodeCLI().main(args)