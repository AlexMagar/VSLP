package controller;

public class CaveController implements ControlledScene{
	
	SceneController myController;

	@Override
	public void setSceneParent(SceneController sceneParent) {
		// TODO Auto-generated method stub
		myController = sceneParent;
	}

}
