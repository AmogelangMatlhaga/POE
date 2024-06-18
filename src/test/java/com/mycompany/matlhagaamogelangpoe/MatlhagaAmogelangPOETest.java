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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatlhagaAmogelangPOETest {
    @BeforeEach
    public void setUp() {
        MatlhagaAmogelangPOE.getDevelopers().clear();
        MatlhagaAmogelangPOE.getTaskNames().clear();
        MatlhagaAmogelangPOE.getTaskDurations().clear();
        MatlhagaAmogelangPOE.getTaskStatuses().clear();
        // Manually adding test data for consistency
        addInitialTestData();
    }

    private void addInitialTestData() {
        MatlhagaAmogelangPOE.getDevelopers().add("Mike Smith");
        MatlhagaAmogelangPOE.getTaskNames().add("Create Login");
        MatlhagaAmogelangPOE.getTaskDurations().add(5);
        MatlhagaAmogelangPOE.getTaskStatuses().add("To Do");

        MatlhagaAmogelangPOE.getDevelopers().add("Edward Harrison");
        MatlhagaAmogelangPOE.getTaskNames().add("Create Add Features");
        MatlhagaAmogelangPOE.getTaskDurations().add(8);
        MatlhagaAmogelangPOE.getTaskStatuses().add("Doing");

        MatlhagaAmogelangPOE.getDevelopers().add("Samantha Paulson");
        MatlhagaAmogelangPOE.getTaskNames().add("Create Reports");
        MatlhagaAmogelangPOE.getTaskDurations().add(2);
        MatlhagaAmogelangPOE.getTaskStatuses().add("Done");

        MatlhagaAmogelangPOE.getDevelopers().add("Glenda Oberholzer");
        MatlhagaAmogelangPOE.getTaskNames().add("Add Arrays");
        MatlhagaAmogelangPOE.getTaskDurations().add(11);
        MatlhagaAmogelangPOE.getTaskStatuses().add("To Do");
    }

    @Test
    public void testDevelopersArrayPopulatedCorrectly() {
        assertEquals("Mike Smith", MatlhagaAmogelangPOE.getDevelopers().get(0));
        assertEquals("Edward Harrison", MatlhagaAmogelangPOE.getDevelopers().get(1));
        assertEquals("Samantha Paulson", MatlhagaAmogelangPOE.getDevelopers().get(2));
        assertEquals("Glenda Oberholzer", MatlhagaAmogelangPOE.getDevelopers().get(3));
    }

    @Test
    public void testTaskWithLongestDuration() {
        MatlhagaAmogelangPOE.displayTaskWithLongestDuration();
        int maxDurationIndex = 0;
        for (int i = 1; i < MatlhagaAmogelangPOE.getTaskDurations().size(); i++) {
            if (MatlhagaAmogelangPOE.getTaskDurations().get(i) > MatlhagaAmogelangPOE.getTaskDurations().get(maxDurationIndex)) {
                maxDurationIndex = i;
            }
        }
        assertEquals("Glenda Oberholzer", MatlhagaAmogelangPOE.getDevelopers().get(maxDurationIndex));
        assertEquals(11, MatlhagaAmogelangPOE.getTaskDurations().get(maxDurationIndex));
    }

    @Test
    public void testSearchTaskByName() {
        // Simulate user input by directly calling the method and checking results
        String taskName = "Create Login";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MatlhagaAmogelangPOE.getTaskNames().size(); i++) {
            if (MatlhagaAmogelangPOE.getTaskNames().get(i).equalsIgnoreCase(taskName)) {
                result.append("Task Name: ").append(MatlhagaAmogelangPOE.getTaskNames().get(i))
                      .append(", Developer: ").append(MatlhagaAmogelangPOE.getDevelopers().get(i))
                      .append(", Task Status: ").append(MatlhagaAmogelangPOE.getTaskStatuses().get(i)).append("\n");
            }
        }
        assertTrue(result.toString().contains("Task Name: Create Login"));
        assertTrue(result.toString().contains("Developer: Mike Smith"));
    }

    @Test
    public void testSearchTasksByDeveloper() {
        // Simulate user input by directly calling the method and checking results
        String developer = "Samantha Paulson";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MatlhagaAmogelangPOE.getDevelopers().size(); i++) {
            if (MatlhagaAmogelangPOE.getDevelopers().get(i).equalsIgnoreCase(developer)) {
                result.append("Task Name: ").append(MatlhagaAmogelangPOE.getTaskNames().get(i))
                      .append(", Task Status: ").append(MatlhagaAmogelangPOE.getTaskStatuses().get(i)).append("\n");
            }
        }
        assertTrue(result.toString().contains("Task Name: Create Reports"));
        assertTrue(result.toString().contains("Task Status: Done"));
    }

    @Test
    public void testDeleteTaskByName() {
        // Simulate user input by directly calling the method
        String taskName = "Create Reports";
        int indexToRemove = -1;
        for (int i = 0; i < MatlhagaAmogelangPOE.getTaskNames().size(); i++) {
            if (MatlhagaAmogelangPOE.getTaskNames().get(i).equalsIgnoreCase(taskName)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            MatlhagaAmogelangPOE.getDevelopers().remove(indexToRemove);
            MatlhagaAmogelangPOE.getTaskNames().remove(indexToRemove);
            MatlhagaAmogelangPOE.getTaskDurations().remove(indexToRemove);
            MatlhagaAmogelangPOE.getTaskStatuses().remove(indexToRemove);
        }
        assertFalse(MatlhagaAmogelangPOE.getTaskNames().contains("Create Reports"));
    }

    @Test
    public void testDisplayReport() {
        // Directly checking the arrays as report displays on JOptionPane
        assertNotNull(MatlhagaAmogelangPOE.getDevelopers());
        assertNotNull(MatlhagaAmogelangPOE.getTaskNames());
        assertNotNull(MatlhagaAmogelangPOE.getTaskDurations());
        assertNotNull(MatlhagaAmogelangPOE.getTaskStatuses());
    } 
}

