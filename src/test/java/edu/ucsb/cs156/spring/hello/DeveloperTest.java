package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Matthew", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_github_id() {
        assertEquals("matthewli10", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s26-08", t.getName());
    }

     @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Matthew"),"Team should contain Matthew");
        assertTrue(t.getMembers().contains("Anjali"),"Team should contain Anjali");
        assertTrue(t.getMembers().contains("Christian"),"Team should contain Christian");
        assertTrue(t.getMembers().contains("Ria"),"Team should contain Ria");
        assertTrue(t.getMembers().contains("Taedon"),"Team should contain Taedon");
        assertTrue(t.getMembers().contains("Wendy"),"Team should contain Wendy");
    }

}
