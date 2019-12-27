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

public class BatsManMokitoTest {
    CricketLeagueAnalyser cricketLeagueAnalyser;
   @Mock
    BatsManAdapter batsManAdapter;
    IPLAdapter iplAdapter;
    Map<String,IPLDAO> batsManMap =null;

    @Rule
    public MockitoRule mockitoRule=MockitoJUnit.rule();
    private static final String IPL_MOST_RUNS_SHEET="/home/admin1/Desktop/CricketLeagueAnalyser/src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Before
    public void setData() throws CricketLeagueAnalyserException, CSVBuilderException {
        batsManMap =new HashMap<>();
        batsManMap.put("Marcus Stonnis",new IPLDAO("B",12,55,33,55));
        batsManMap.put("Sunil Narine",new IPLDAO("A",30,105,55,22));
        batsManMap.put("Chris Gayle",new IPLDAO("Z",66,200,69,66));
        BatsManAdapter batsManAdapter=mock(BatsManAdapter.class);
            cricketLeagueAnalyser=new CricketLeagueAnalyser(batsManAdapter);
            when(iplAdapter.loadCensusData(CricketLeagueAnalyser.Player.BATSMAN,IPL_MOST_RUNS_SHEET)).thenReturn(batsManMap); {
        }

    }

    @Test
    public void givenMethod_ShouldReturnNumberOfRecords() throws CricketLeagueAnalyserException {
        Map<String, IPLDAO> data = null;
        data = iplAdapter.loadCensusData(CricketLeagueAnalyser.Player.BATSMAN, IPL_MOST_RUNS_SHEET);
        Assert.assertEquals(3,data.size());
    }
}

