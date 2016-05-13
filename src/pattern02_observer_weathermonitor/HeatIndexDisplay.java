package pattern02_observer_weathermonitor;

public class HeatIndexDisplay implements DisplayElement, WeatherConditionObserver {

	private double mHeatIndex;
	
	Subject mWeatherData;
	
	HeatIndexDisplay (Subject s)
	{
		mWeatherData = s;
		mWeatherData.registerObserver(this);
	}
	
	@Override
	public void update(WeatherUpdateEvent e) {
		double t = e.getTeperature();
		double rh = e.getHumidity();
		mHeatIndex = (
				(16.923 + (0.185212 * t)) + 
				(5.37941 * rh) - 
				(0.100254 * t * rh) + 
				(0.00941695 * (t * t)) + 
				(0.00728898 * (rh * rh)) + 
				(0.000345372 * (t * t * rh)) - 
				(0.000814971 * (t * rh * rh)) +
				(0.0000102102 * (t * t * rh * rh)) - 
				(0.000038646 * (t * t * t)) + 
				(0.0000291583 * (rh * rh * rh)) +
				(0.00000142721 * (t * t * t * rh)) + 
				(0.000000197483 * (t * rh * rh * rh)) - 
				(0.0000000218429 * (t * t * t * rh * rh)) +
				(0.000000000843296 * (t * t * rh * rh * rh)) -
				(0.0000000000481975 * (t * t * t * rh * rh * rh)));
		
		display();
		
	}

	@Override
	public void display() {
		System.out.println("Heat index is " + mHeatIndex);
		
	}

}
