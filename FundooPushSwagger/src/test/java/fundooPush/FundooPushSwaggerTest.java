package fundooPush;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FundooPushSwaggerTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://fundoopush-backend-dev.bridgelabz.com/api";
    }

    @Test
    public void givenMethodFor_IfRegisterSuccessful_ReturnTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"email\":\"JitendraPatil077@gmail.com\",\"password\":\"abcd1234\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/registration");
        ResponseBody body = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusCode();
        boolean status = (boolean) object.get("status");
        System.out.println(statusCode);
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Registered Successfully", message);

    }

    @Test
    public void givenMethodFor_IfProvideEmailIdAsNull_ReturnFalse() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\"email\":\"\",\"password\":\"12364\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/registration");
        ResponseBody body = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(false, status);
        Assert.assertEquals("email is required", message);

    }

    @Test
    public void givenMethodFor_IfProvidePasswordNull_ReturnFalse() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\"email\":\"JitendraPatil7@gmail.com\",\"password\":\"\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/registration");
        ResponseBody body = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(false, status);
        Assert.assertEquals("password is required", message);
    }

    @Test
    public void givenMethodFor_IfProvideBothFieldsAreNull_ReturnFalse() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\"email\":\"\",\"password\":\"\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/registration");
        ResponseBody body = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(body.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(false, status);
        Assert.assertEquals("email is required", message);
    }

    @Test
    public void givenMethodFor_IfLoginCredentialsIsValid_ReturnTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"email\":\"JitendraPatil7@gmail.com\",\"password\":\"abcd1234\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/login");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Logged in Successfully", message);
    }

    @Test
    public void givenMethodFor_IfEnteredUnRegisteredEmail_ReturnFalse() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"email\":\"JitendraPatil71@gmail.com\",\"password\":\"abcd1234\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/login");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(false, status);
        Assert.assertEquals("Not a registered user", message);
    }

    @Test
    public void givenMethodFor_IfLogOutSuccessful_ReturnTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVlMDk5N2QxNGQyMjY3" +
                        "MDAzMjUzMGYzMiJ9LCJpYXQiOjE1Nzc3MDcwNzMsImV4cCI6MTU3Nzc5MzQ3M30.VR_5bNZ6gj4XsBjl9sse9qIL5KcCPNDqPYVbqevnVKc")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/logout");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Logged out successfully from the system", message);
    }

    @Test
    public void givenMethodFor_IfPassesInCorrectHeader_ReturnFalse() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token", "e+yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVlMDk5N2QxNGQyMjY3" +
                        "MDAzMjUzMGYzMiJ9LCJpYXQiOjE1Nzc3MDcwNzMsImV4cCI6MTU3Nzc5MzQ3M30.VR_5bNZ6gj4XsBjl9sse9qIL5KcCPNDqPYVbqevnVKc")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/logout");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        Assert.assertEquals(false, status);

    }

    @Test
    public void givenMethodFor_IfRedirectSuccessfully_ReturnTrue() {
        File file = new File("/home/admin265/Pictures/Screenshot from 2019-07-25 17-02-49.png");
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6I" +
                        "jVlMGFlYmQ2NDQ3N2RjMDAzMmNkYjY0MyJ9LCJpYXQiOjE1Nzc3NzQwN" +
                        "jksImV4cCI6MTU3Nzg2MDQ2OX0.g_nsW0r-xRQvBlO6gVFf-qyXnjwhd2oYLHyV9r5O0O8")
                .multiPart("image", file)
                .formParam("title", "automation")
                .formParam("description", "automation testing pdf")
                .formParam("redirect_link", "www.google.com")
                .post("https://fundoopush-backend-dev.bridgelabz.com/redirects");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Redirect added Successfully", message);
    }

    @Test
    public void givenMethodFor_IfUpdateRedirectSuccessfully_ReturnTrue() {
        File file = new File("/home/admin265/Pictures/Screenshot from 2019-07-25 17-02-49.png");
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6I" +
                        "jVlMGFlYmQ2NDQ3N2RjMDAzMmNkYjY0MyJ9LCJpYXQiOjE1Nzc3NzQwN" +
                        "jksImV4cCI6MTU3Nzg2MDQ2OX0.g_nsW0r-xRQvBlO6gVFf-qyXnjwhd2oYLHyV9r5O0O8")
                .formParam( "_id", "5e0aefa44d22670032531076")
                .multiPart("image", file)
                .formParam("title", "automation")
                .formParam("description", "automation testing pdf")
                .formParam("redirect_link", "www.google.com")
                .put("https://fundoopush-backend-dev.bridgelabz.com/redirects");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Redirect updated Successfully", message);

    }

    @Test
    public void givenMethodFor_IfGetAllRedirectsSuccessfully_ReturnTrue() {
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6I" +
                        "jVlMGFlYmQ2NDQ3N2RjMDAzMmNkYjY0MyJ9LCJpYXQiOjE1Nzc3NzQwN" +
                        "jksImV4cCI6MTU3Nzg2MDQ2OX0.g_nsW0r-xRQvBlO6gVFf-qyXnjwhd2oYLHyV9r5O0O8")
                .get("https://fundoopush-backend-dev.bridgelabz.com/redirects");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("All Redirects retrieved Successfully", message);
    }

    @Test
    public void givenMethodFor_IfRedirectDeletedSuccessfully_ReturnTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVjODY1YTc0OWZkNTkxNWFjNjQwZDZhNyJ9LCJpYXQiOjE1Nzc3NzI1NjAsImV4cCI6MTU3Nzg1ODk2MH0.MweF2N9IGHo-yzxLYRFcYSC6koz-X8mDN6WY7keEHWw")
                .body("{\"_id\":\"5e0ae66f6503ac0032e162ba\"}")
                .when()
                .post("https://fundoopush-backend-dev.bridgelabz.com/redirects/delete");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Redirect deleted Successfully", message);
    }

    @Test
    public void givenMethodFor_AllRedirectsFromBLSite() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("https://fundoopush-backend-dev.bridgelabz.com/bl-redirects");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("All Redirects retrieved Successfully", message);
    }

    @Test
    public void givenMethodFor_IfHashTagEditSuccessfullyReturnsTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVlMGFmNTM4NGQyMjY3MDAzMjUzMTA4YyJ9LCJpYXQiOjE1Nzc3N" +
                        "zY0NTAsImV4cCI6MTU3Nzg2Mjg1MH0.71Y1Zc1Y3QS0BGl8fR2DMBwR1EhPKDjKSC2-eB2hnq0")
                .body("{\"redirect_id\":\"5e0af3e164eda20032e123ae\",\"hashtag\": \"#bridgelabz #solutions #mumbai #bangalore #fundoopush\"}")
                .post("https://fundoopush-backend-dev.bridgelabz.com/hashtag/edit");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Hashtag edit done Successfully", message);
    }

    @Test
    public void givenMethodFor_RedirectsOnHashTagBYName_ReturnsTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVlMGFmNTM4NG" +
                        "QyMjY3MDAzMjUzMTA4YyJ9LCJpYXQiOjE1Nzc3NzY0NTAsImV4cCI6MTU3Nzg2Mjg1MH0.71Y1Zc1Y3QS0BGl8fR2DMBwR1EhPK" +
                        "DjKSC2-eB2hnq0")
                .get("https://fundoopush-backend-dev.bridgelabz.com/redirects/hashtag/%23bridgeLabZ-%23Pune");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Hashtag sent Successfully", message);
    }

    @Test
    public void givenMethodFor_IfScrapTheDataFromUrlSuccessfully_ReturnsTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9p" +
                        "ZCI6IjVlMGFmNTM4NGQyMjY3MDAzMjUzMTA4YyJ9LCJpYXQiOjE1Nzc3NzY0NTAsImV4cCI6MTU3Nz" +
                        "g2Mjg1MH0.71Y1Zc1Y3QS0BGl8fR2DMBwR1EhPKDjKSC2-eB2hnq0")
                .body("{\"url\": \"https://www.deccanchronicle.com/technology/in-other-news/270319/companies-that-are-changing-the-way-education-is-being-delivered-to-st.html\"}")
                .post("https://fundoopush-backend-dev.bridgelabz.com/web-scraping");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Successfully scrapped data", message);
    }

    @Test
    public void givenMethodFor_SearchParticularHashTagIfFound_ReturnTrue() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVlMGFmNTM4NGQyMjY3MDAzMjUzMTA4YyJ9LCJpYXQiOjE1Nzc3NzY0NTAsImV4cCI6MTU3Nzg2Mjg1MH0.71Y1Zc1Y3QS0BGl8fR2DMBwR1EhPKDjKSC2-eB2hnq0")
                .body("{\"hashtag\": \"#bridgelabz\"}")
                .post("https://fundoopush-backend-dev.bridgelabz.com/search/hashtag");
        ResponseBody responseBody = response.getBody();
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(responseBody.prettyPrint());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        boolean status = (boolean) object.get("status");
        String message = (String) object.get("message");
        Assert.assertEquals(true, status);
        Assert.assertEquals("Successfully searched data", message);

    }

    @Test
    public void givenMethodFor_PostTheJobSuccessfullyReturnTrue() {
        Response response=RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Il9pZCI6IjVjODY1YTc0" +
                        "OWZkNTkxNWFjNjQwZDZhNyJ9LCJpYXQiOjE1Nzc3OTU3OTEsImV4cCI6MTU3Nzg4MjE5MX0.qlxXe75KlQGkhlU3chOh9wEWEYl23lBGu02MZi9ZY9g")
                .body("{\"redirect_id\":\"5e0adda14d2267003253102e\",\"years_of_experience\":\"1\",\"salary\":\"3.6\",\"location\":\"Mumbai\"" +
                        ",\"company_profile\":\"Ideation\"}")
                .when()
                .post("/jobs");
        ResponseBody responseBody = response.getBody();
        int status=response.getStatusCode();
        System.out.println(responseBody);
        String string=response.asString();
        Assert.assertEquals(status,200);
    }
}
