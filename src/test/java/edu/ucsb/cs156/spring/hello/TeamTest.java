package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    //Case 1
    public void equals_same_object(){   
        assertTrue(team.equals(team));
    }

    @Test
    //Case 2
    public void equals_diff_class(){
        String string = "string";
        assertFalse(team.equals(string));
    }

    @Test
    //Case 3.1
    public void equals_name_and_members(){
        Team newTeam = new Team("test-team");
        assertTrue(team.equals(newTeam));
    }

    @Test
    //Case 3.2
    public void equals_name_and_diff_members(){
        Team newTeam = new Team("test-team");
        newTeam.addMember("Alice");
        assertFalse(team.equals(newTeam));
    }

    @Test
    //Case 3.3
    public void equals_diff_name_and_members(){
        Team diffTeam = new Team("diffTeam");
        assertFalse(team.equals(diffTeam));
    }

    @Test
    //Case 3.4
    public void equals_diff_name_and_diff_members(){
        Team diffTeam = new Team("diffTeam");
        diffTeam.addMember("Alice");
        assertFalse(team.equals(diffTeam));
    }

    @Test
    public void hashCode_returns_same_value_for_equal_objects() {
        Team newteam = new Team("test-team");
        assertEquals(team.hashCode(), newteam.hashCode());
    }

    @Test
    public void hashCode_returns_different_value_for_unequal_objects() {
        Team newteam = new Team("different-team");
        assertNotEquals(team.hashCode(), newteam.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        int expectedHashCode = team.getName().hashCode() | team.getMembers().hashCode();
        assertEquals(expectedHashCode, team.hashCode());
    }

}
