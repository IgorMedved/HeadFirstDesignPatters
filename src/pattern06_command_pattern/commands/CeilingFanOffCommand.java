package pattern06_command_pattern.commands;

import pattern06_command_pattern.receivers.CeilingFan;

public class CeilingFanOffCommand implements Command
{
	private CeilingFan mFan;
	private int mPreviousSpeed;
	
	public CeilingFanOffCommand(CeilingFan fan)
	{
		mFan = fan;
		mPreviousSpeed = mFan.getSpeed();
	}
	
	
	@Override
	public void execute()
	{
		mPreviousSpeed =mFan.getSpeed();
		mFan.off();
	}
	
	public void undo ()
	{
		int temp = mFan.getSpeed();
		
		if (mPreviousSpeed == CeilingFan.HIGH)
			mFan.high();
		else if (mPreviousSpeed == CeilingFan.MEDIUM)
			mFan.medium();
		else if (mPreviousSpeed == CeilingFan.LOW)
			mFan.low();
		else if (mPreviousSpeed == CeilingFan.OFF)
			mFan.off();
		
		mPreviousSpeed = temp;
	}
	

}
