package lesson57.extra;
import lessonRunner.BaseLesson;

// LESSON 57 EXTRA - Check the chain
// The last piece of every log line is the MD5 hash of the line BEFORE it. The first line
// hashes a fixed starting text instead: 4X#f9qdkEkzHEGGK
//
// TASK:
// 1. Copy the md5(String) helper from LESSON57.md as it is. It's a library call, not the
//    point of the lesson.
// 2. Write  static int firstBrokenLine(List<String> lines)  - the line number (from 1) of
//    the first line whose stored hash isn't md5 of the line before it, or -1 if all check
//    out. Start "previous" at the fixed text. The stored hash is everything after the LAST
//    | (lastIndexOf).
// 3. Run it on resources/lesson57-robot-log.txt.
// 4. In memory only - never edit the real file - use lines.set(...) to change line 3's value
//    from 0.0 to 400.0, and check again. PREDICT which line it reports first.
// 5. Point it at your own lesson56.basic-output.log too. Same format, same starting text.
//
// Expected:
//   Chain OK: all 382 lines check out
//   After editing line 3: BROKEN at line 4
//
// LINE 4, NOT 3: line 3's hash describes line 2, which you didn't touch. Line 4 holds the
// fingerprint of line 3. And be honest about what this proves: anyone who reads
// LessonLogger.java could fake a log. The chain catches accidents, not a determined faker.
public class Main extends BaseLesson {
    public static void main(String[] args) {
    }
}
