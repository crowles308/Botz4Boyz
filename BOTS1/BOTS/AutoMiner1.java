
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*@ScriptManifest(authors = {"Liam Crowley, Eli Lagorgia"}, keywords = {"Mining","Frist"}, name = "AutoMiner", description = "An attempt at an AutoMiner", version = 1)
*/
public class AutoMiner extends PollingScript<ClientContext>
{
    private List<Task> taskList = new ArrayList<Task>();
    
    @Override
    public void start() 
    {
        taskList.addAll(Arrays.asList(new MineIron1(ctx), new DropIron1(ctx)));
    }
    
    @Override
    public void poll() 
    {
        for (Task task : taskList)
        {
            if(task.activate())
            {
                task.execute();
            }
        }
    }
}
