package cricketleagueanalyser;

import com.bridgelabzs.CSVBuilderException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BowlerMokitoTest {
    Map<String, IPLDAO> bowlerData = null;
    private static final String IPL_MOST_WICKET_SHEET= "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    CricketLeagueAnalyser cricketLeagueAnalyser;
    @Mock
    BowlerAdapter bowlerAdapter;
    Map<String,IPLDAO> bowlerMap =null;
    @Rule
    public MockitoRule mockitoRule=MockitoJUnit.rule();
    @Before
    public void setData() throws CricketLeagueAnalyserException{
        bowlerMap =new HashMap<>();
        bowlerMap.put("Imran Tahir",new IPLDAO("Imran Tahir",8.33,66,69,3));
        bowlerMap.put("Kasigo Rabada",new IPLDAO("kasigo Rabada",7.33,55,82,6));
        bowlerMap.put("Deepak Chahar",new IPLDAO("Deepak Chahar",6.33,45,65,3));
        BatsManAdapter bowlerAdapter=mock(BatsManAdapter.class);
        when(bowlerAdapter.loadCensusData(CricketLeagueAnalyser.Player.BOWLER,IPL_MOST_WICKET_SHEET)).thenReturn(bowlerMap);
        cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.setAdapter(bowlerAdapter);
    }

    @Test
    public void givenMethod_ShouldReturnNumberOfRecords() throws CricketLeagueAnalyserException {
        Map<String, IPLDAO> data = null;
        data = bowlerAdapter.loadCensusData(CricketLeagueAnalyser.Player.BOWLER, IPL_MOST_WICKET_SHEET);
        Assert.assertEquals(3,data.size());
    }
}
