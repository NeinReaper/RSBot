package deprecatedNodeSystem;

import java.util.LinkedList;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;

public class NodeEmployment {
	public Tree mainTree;
	public LinkedList<Job> jobBuilder = new LinkedList<Job>();

	public void load(Job... charge) {
		if(charge != null) {
			for(Job j : charge){
				if(j != null && !jobBuilder.contains(j)){
					jobBuilder.add(j);
				}
			}
		}
		mainTree = new Tree(jobBuilder.toArray(new Node[jobBuilder.size()]));
	}
	public void fire(ActiveScript script){
		if(mainTree != null) {
			Job charge = mainTree.state();
			if(charge != null) {
				if(jobBuilder.contains(charge)) {
					charge = jobBuilder.get(jobBuilder.indexOf(charge));
					script.getContainer().submit(charge);
					charge.join();
				} else {
					mainTree = new Tree(jobBuilder.toArray(new Node[jobBuilder.size()]));
				}
			}
		}
	}

}
