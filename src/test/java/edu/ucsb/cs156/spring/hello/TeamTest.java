package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_differentClass_returnsFalse() {
        assertFalse(team.equals("not a team"));
        assertFalse(team.equals(new Object()));
    }

    @Test
    public void equals_sameNameAndMembers_returnsTrue() {
        Team a = new Team("red");
        Team b = new Team("red");
        a.addMember("alice");
        b.addMember("alice");
        assertTrue(a.equals(b));
    }

    @Test
    public void equals_sameNameDifferentMembers_returnsFalse() {
        Team a = new Team("red");
        a.addMember("alice");
        Team b = new Team("red");
        b.addMember("bob");
        assertFalse(a.equals(b));
    }

    @Test
    public void equals_differentName_returnsFalse() {
        Team a = new Team("red");
        Team b = new Team("blue");
        assertFalse(a.equals(b));
    }

    @Test
    public void hashCode_sameContents_returnsSameValue() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_matchesCombinedValueForKnownTeam() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");
        int expectedResult = 130294;
        assertEquals(expectedResult, t.hashCode());
    }

}
