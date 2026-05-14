public class UI
{
    SubmissionController submissionController;

    public UI()
    {
        this.submissionController = new SubmissionController();
    }

    public void submit (Submission data)
    {
        submissionController.validateFormat(data);
    }

    public void runBenchmark(int iterations)
    {
        Database db = submissionController.getDb();
        
        db.saveReviewer(new Reviewer("Alice"));
        db.saveReviewer(new Reviewer("Bob"));
        db.saveReviewer(new Reviewer("Charlie"));

        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; ++i)
        {
            Submission paper = new Submission("Benchmark Paper " + i, "Alice");
            paper.isValid = true;

            submissionController.validateFormat(paper);

            db.saveReview(new Review("Bob", paper.getTitle(), 8));
            db.saveReview(new Review("Charlie", paper.getTitle(), 7));

            submissionController.startEvaluation();
        }

        long endTime = System.nanoTime();
        long totalDurationNs = endTime - startTime;
        double totalDurationMs = totalDurationNs / 1_000_000.0;
        double averageDurationMs = totalDurationMs / iterations;

        System.out.println("\n--- Benchmark Results ---");
        System.out.println("Total Iterations: " + iterations);
        System.out.println("Total Execution Time: " + totalDurationMs + " ms");
        System.out.println("Average Time per Run: " + averageDurationMs + " ms");
    }

    public static void main(String[] args)
    {
        UI app = new UI();
        int testRuns = 1;
        
        System.out.println("Starting benchmark for " + testRuns + " iterations...");
        app.runBenchmark(testRuns);
    }
}