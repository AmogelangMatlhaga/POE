/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.matlhagaamogelangpoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lethabo Molate
 */
public class TaskTest {

    @Test
    public void testTaskDescriptionLengthSuccess() {
        Task task = new Task(0, "Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(), "Task description is within 50 characters");
    }

    @Test
    public void testTaskDescriptionLengthFailure() {
        Task task = new Task(0, "Login Feature", "This description is deliberately made longer than fifty characters to test failure condition", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription(), "Task description exceeds 50 characters");
    }

    @Test
    public void testTaskCreationSuccessMessage() {
        Task task = new Task(0, "Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        String expectedDetails = """
                                 Task Status: To Do
                                 Developer Details: Robyn Harrison
                                 Task Number: 0
                                 Task Name: Login Feature
                                 Task Description: Create Login to authenticate users
                                 Task ID: LO:0:SON
                                 Duration: 8 hours""";
        assertEquals(expectedDetails, task.printTaskDetails());
    }

    @Test
    public void testTaskIDGeneration() {
        Task task = new Task(0, "Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task.getTaskID());

        Task task2 = new Task(1, "Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        assertEquals("AD:1:ITH", task2.getTaskID());
    }

    @Test
    public void testTotalHoursAccumulation() {
        Task[] tasks = {
            new Task(0, "Task 1", "Description 1", "Developer 1", 10, "To Do"),
            new Task(1, "Task 2", "Description 2", "Developer 2", 12, "Doing"),
            new Task(2, "Task 3", "Description 3", "Developer 3", 55, "Done"),
            new Task(3, "Task 4", "Description 4", "Developer 4", 11, "To Do"),
            new Task(4, "Task 5", "Description 5", "Developer 5", 1, "Doing")
        };

        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getDuration();
        }

        assertEquals(89, totalHours, "Total hours for all tasks should be 89");
    }

    @Test
    public void testTotalHoursWithInitialData() {
        Task task1 = new Task(0, "Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        Task task2 = new Task(1, "Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

        Task[] tasks = {task1, task2};
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getDuration();
        }

        assertEquals(18, totalHours, "Total hours for initial two tasks should be 18");
    }

}
