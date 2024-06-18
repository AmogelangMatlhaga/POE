/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matlhagaamogelangpoe;

/**
 *
 * @author Lethabo Molate
 */
public class Task {
    private final int taskNumber;
    private final String taskName;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskID;
    private String taskStatus;

    public Task(int taskNumber, String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID(taskName, developerDetails);
        this.taskStatus = taskStatus;
    }

    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getTaskID() {
        return taskID;
    }

    private String createTaskID(String taskName, String developerDetails) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    public int getDuration() {
        return taskDuration;
    }    
}
