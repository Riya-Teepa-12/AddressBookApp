package com.addressbookapp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookJsonServerTest {

	/*
	 * IMPORTANT: Start JSON Server before running this test.
	 *
	 * This test retrieves contacts from a mock REST API provided by json-server.
	 * The server must be running on port 3000 with the db.json file.
	 *
	 * Command to start JSON Server:
	 *
	 * json-server --watch src/test/resources/testdata/db.json --port 3000
	 *
	 * After starting the server, verify it using:
	 * curl http://localhost:3000/contacts
	 *
	 * Expected: JSON response containing contact records.
	 */
	
    @Test
    public void givenJSONServer_whenContactsFetched_shouldReturnRecords() {

        Response response = RestAssured.get("http://localhost:3000/contacts");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode());

        //System.out.println(response.getBody().asPrettyString());
    }
}