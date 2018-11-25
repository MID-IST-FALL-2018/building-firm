class BuildingFirm {

  // Constant
  final int NUM_SPECIALISTS = 2;
  final int NUM_HOUSES = 3;

  // TODO: Monitor definitions
  // Monitor m = ...
  // You may use as many monitors as you need

  class TeamManager extends Thread {
    public void run() {
      // TODO: fix the method according to the constratins in the README.md
      for (int i=0; i<NUM_HOUSES ; i++) {
        startTeamManager();
        waitWorkersFinish();
      }
    }

    public void startTeamManager() {
      System.out.println("Team manager tells to start working");
    }

    public void waitWorkersFinish() {
      System.out.println("Team manager waits for the workers to finish");
    }
  }

  class Worker extends Thread {
    public void run() {
      // TODO: fix the method according to the constratins in the README.md
      for (int i=0; i<NUM_HOUSES ; i++) {
        work();
        done();
      }
    }

    public void work() {
      System.out.println("Worker " + this.getId() + " is working");
    }

    public void done() {
      System.out.println("Worker " + this.getId() + " done");
    }
  }

  public BuildingFirm() {
    for (int i = 0; i<NUM_SPECIALISTS; i++) {
      new Worker().start();
    }
    new TeamManager().start();

    try {
      for (int i = 0; i<NUM_SPECIALISTS; i++) {
        new Worker().join();
      }
      new TeamManager().join();
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    new BuildingFirm();
  }
}
