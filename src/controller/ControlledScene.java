package controller;

public interface ControlledScene {
	
	//this method will allow the injection of the Parent ScenePane
	public void setSceneParent(SceneController sceneParent);

	
	public void makeDecision(String output);

	public void detectCollision();

}
