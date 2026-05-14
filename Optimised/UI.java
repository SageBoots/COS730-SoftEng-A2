public class UI {
    SubmissionController controller = new SubmissionController();

    public void runBenchmark(int iterations)
    {
        Database db = controller.getDb();

        db.saveReviewer(new Reviewer("ReviewerA"));
        db.saveReviewer(new Reviewer("ReviewerB"));

        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; ++i)
        {
            Submission paper = new Submission("Paper" + i, "Author" + i);
            paper.isValid = true;
            
            controller.validateFormat(paper);
            
            db.saveReview(new Review("ReviewerA", paper.getTitle(), 8));
            db.saveReview(new Review("ReviewerB", paper.getTitle(), 7));
            
            controller.startEvaluation();
        }

        long endTime = System.nanoTime();
        double totalTimeMs = (endTime - startTime) / 1_000_000.0;
        double avgTime = totalTimeMs / iterations;

        System.out.println("--- Benchmark Results ---");
        System.out.println("Total Time: " + totalTimeMs + " ms");
        System.out.println("Avg per run: " + avgTime + " ms");
    }

    public static void main(String[] args)
    {
        UI app = new UI();
        app.runBenchmark(1000);
    }
}