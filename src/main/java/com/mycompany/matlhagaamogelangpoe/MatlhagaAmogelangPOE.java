/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matlhagaamogelangpoe;

/**
 *
 * @author Lethabo Molate
 */
import javax.swing.*;
import java.util.ArrayList;
public class MatlhagaAmogelangPOE {

    private static final ArrayList<String> developers = new ArrayList<>();
    private static final ArrayList<String> taskNames = new ArrayList<>();
    private static final ArrayList<String> taskIDs = new ArrayList<>();
    private static final ArrayList<Integer> taskDurations = new ArrayList<>();
    private static final ArrayList<String> taskStatuses = new ArrayList<>();

    public static void main(String[] args) {
        // Add initial test data
        addInitialTestData();

        boolean loggedIn = false;

        while (!loggedIn) {
            String username = JOptionPane.showInputDialog("Enter username:");
            String password = JOptionPane.showInputDialog("Enter password:");
            String firstName = JOptionPane.showInputDialog("Enter first name:");
            String lastName = JOptionPane.showInputDialog("Enter last name:");

            // Create the account
            Account account = new Account(username, password, firstName, lastName);

            // Validate username and password
            if (account.isUsernameValid()) {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, account.getUsernameErrorMessage());
                continue; // Restart the loop if username is invalid
            }

            if (account.isPasswordValid()) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, account.getPasswordErrorMessage());
                continue; // Restart the loop if password is invalid
            }

            // Create the login section
            Login login = new Login(account);

            // Login process
            String enteredUsername = JOptionPane.showInputDialog("Enter your credentials to login:\nEnter username:");
            String enteredPassword = JOptionPane.showInputDialog("Enter password:");

            loggedIn = login.loginUser(enteredUsername, enteredPassword);
            JOptionPane.showMessageDialog(null, login.returnLoginStatus(loggedIn));
        }

        // User logged in successfully
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        Task[] tasks = new Task[0];
        boolean running = true;

        while (running) {
            String[] options = {"Add tasks", "Show report", "Display tasks with status 'done'", "Display task with longest duration", 
                                "Search task by name", "Search tasks by developer", "Delete task by name", "Quit"};
            JList<String> list = new JList<>(options);
            JScrollPane scrollPane = new JScrollPane(list);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JOptionPane.showMessageDialog(null, scrollPane, "Menu", JOptionPane.PLAIN_MESSAGE);

            String selectedOption = list.getSelectedValue();
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected. Please select an option.");
                continue;
            }

            switch (selectedOption) {
                case "Add tasks":
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add:"));
                    Task[] newTasks = new Task[tasks.length + numTasks];
                    System.arraycopy(tasks, 0, newTasks, 0, tasks.length);

                    for (int i = tasks.length; i < newTasks.length; i++) {
                        newTasks[i] = addTask(i);
                    }

                    tasks = newTasks;
                    int totalHours = getTotalHours(tasks);
                    JOptionPane.showMessageDialog(null, "Total hours: " + totalHours);
                    break;
                case "Show report":
                    displayReport(tasks);
                    break;
                case "Display tasks with status 'done'":
                    displayTasksWithStatusDone();
                    break;
                case "Display task with longest duration":
                    displayTaskWithLongestDuration();
                    break;
                case "Search task by name":
                    searchTaskByName();
                    break;
                case "Search tasks by developer":
                    searchTasksByDeveloper();
                    break;
                case "Delete task by name":
                    deleteTaskByName();
                    break;
                case "Quit":
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
            }
        }
    }

    private static void addInitialTestData() {
        developers.add("Mike Smith");
        taskNames.add("Create Login");
        taskDurations.add(5);
        taskStatuses.add("To Do");
        taskIDs.add("CL:0:ITH");

        developers.add("Edward Harrison");
        taskNames.add("Create Add Features");
        taskDurations.add(8);
        taskStatuses.add("Doing");
        taskIDs.add("CA:1:SON");

        developers.add("Samantha Paulson");
        taskNames.add("Create Reports");
        taskDurations.add(2);
        taskStatuses.add("Done");
        taskIDs.add("CR:2:SON");

        developers.add("Glenda Oberholzer");
        taskNames.add("Add Arrays");
        taskDurations.add(11);
        taskStatuses.add("To Do");
        taskIDs.add("AA:3:ZER");
    }

    private static Task addTask(int taskNumber) {
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description:");

        while (taskDescription.length() > 50) {
            taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:\nEnter task description:");
        }

        String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));

        String[] statusOptions = {"To Do", "Done", "Doing"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

        Task task = new Task(taskNumber, taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        JOptionPane.showMessageDialog(null, "Task successfully captured\n" + task.printTaskDetails());

        // Populate arrays
        developers.add(developerDetails);
        taskNames.add(taskName);
        taskIDs.add(task.getTaskID());
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);

        return task;
    }

    private static int getTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getDuration();
        }
        return totalHours;
    }

    private static void displayReport(Task[] tasks) {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    private static void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                result.append("Developer: ").append(developers.get(i)).append(", Task Name: ").append(taskNames.get(i)).append(", Task Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    static void displayTaskWithLongestDuration() {
        int maxDurationIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxDurationIndex)) {
                maxDurationIndex = i;
            }
        }
        String result = "Developer: " + developers.get(maxDurationIndex) + ", Task Duration: " + taskDurations.get(maxDurationIndex) + " hours";
        JOptionPane.showMessageDialog(null, result);
    }

    static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                result.append("Task Name: ").append(taskNames.get(i)).append(", Developer: ").append(developers.get(i)).append(", Task Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        if (result.length() == 0) {
            JOptionPane.showMessageDialog(null, "No tasks found with the name: " + taskName);
        } else {
            JOptionPane.showMessageDialog(null, result.toString());
        }
    }

    private static void searchTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog("Enter the developer name to search:");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) {
                result.append("Task Name: ").append(taskNames.get(i)).append(", Task Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        if (result.length() == 0) {
            JOptionPane.showMessageDialog(null, "No tasks found for developer: " + developer);
        } else {
            JOptionPane.showMessageDialog(null, result.toString());
        }
    }

    static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        int indexToRemove = -1;
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            developers.remove(indexToRemove);
            taskNames.remove(indexToRemove);
            taskIDs.remove(indexToRemove);
            taskDurations.remove(indexToRemove);
            taskStatuses.remove(indexToRemove);
            JOptionPane.showMessageDialog(null, "Task " + taskName + " has been deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found with the name: " + taskName);
        }
    }

    // Getter methods for testing purposes
    public static ArrayList<String> getDevelopers() {
        return developers;
    }

    public static ArrayList<String> getTaskNames() {
        return taskNames;
    }

    public static ArrayList<String> getTaskStatuses() {
        return taskStatuses;
    }

    public static ArrayList<Integer> getTaskDurations() {
        return taskDurations;
    }
}
