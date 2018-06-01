//
//  ViewController.swift
//  WeatherApp
//
//  Created by Angela Yu on 23/08/2015.
//  Copyright (c) 2015 London App Brewery. All rights reserved.
//

import UIKit
import CoreLocation
import Alamofire
import SwiftyJSON

class WeatherViewController: UIViewController, CLLocationManagerDelegate, ChangeCityDelegate {
    
    //Constants
    let WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather"
    let APP_ID = "7f9c658adbafaf08529b04b1b705d116"
    

    //TODO: Declare instance variables here
    
    let locationManager = CLLocationManager()
    let weatherDataModel = WeatherDataModel()
    var celsiusDisplay : Bool = true
    var cTemp : Int = 0
    var fTemp : Int = 0
    var units : String = "C"
    
    //Pre-linked IBOutlets
    @IBOutlet weak var weatherIcon: UIImageView!
    @IBOutlet weak var cityLabel: UILabel!
    @IBOutlet weak var temperatureLabel: UILabel!
    @IBOutlet weak var switchCAndF: UISwitch!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //TODO:Set up the location manager here.
    
        locationManager.delegate = self
        locationManager.desiredAccuracy = kCLLocationAccuracyHundredMeters
        locationManager.requestWhenInUseAuthorization()
        locationManager.startUpdatingLocation()
    }
    
    //MARK: - Switch
    /***************************************************************/
    @IBAction func celciusDecider(_ sender: UISwitch) {
        if sender.isOn {
            celsiusDisplay = false
            switchCAndF.setOn(false, animated: true)
            weatherDataModel.temperature = fTemp
            units = "F"
        } else {
            celsiusDisplay = true
            switchCAndF.setOn(true, animated: true)
            weatherDataModel.temperature = cTemp
            units = "C"
        }
        updateUIWithWeatherData()
    }
    
    

    //MARK: - Networking
    /***************************************************************/
    
    //Write the getWeatherData method here:
    func getWeatherData( url: String, parameters : [String:String]) {
        Alamofire.request(url, method : .get, parameters : parameters).responseJSON {
            response in
            if response.result.isSuccess {
                let weatherJSON : JSON = JSON(response.result.value!)
                self.updateWeatherData(json : weatherJSON)
            } else {
                self.cityLabel.text = "Connection Issues"
            }
        }
        
        
        
    }

    //MARK: - JSON Parsing
    /***************************************************************/
   
    
    //Write the updateWeatherData method here:
    func updateWeatherData(json : JSON) {
        if let tempResult = json["main"]["temp"].double {
            cTemp = Int(tempResult - 273.15)
            fTemp = Int(tempResult * 1.8 - 459.67)
            if celsiusDisplay {
                weatherDataModel.temperature = cTemp
            } else {
                weatherDataModel.temperature = fTemp
            }
            weatherDataModel.city = json["name"].stringValue
            weatherDataModel.condition = json["weather"][0]["id"].intValue
            weatherDataModel.weatherIconName = weatherDataModel.updateWeatherIcon(condition : weatherDataModel.condition)
            
            updateUIWithWeatherData()
        } else {
            cityLabel.text = "Weather Unavailable"
        }
    }
    
    //MARK: - UI Updates
    /***************************************************************/
    
    
    //Write the updateUIWithWeatherData method here:
    func updateUIWithWeatherData() {
        cityLabel.text = weatherDataModel.city
        temperatureLabel.text = "\(weatherDataModel.temperature)° \(units)"
        weatherIcon.image = UIImage(named: weatherDataModel.weatherIconName)
        
        
    }
    
    //MARK: - Location Manager Delegate Methods
    /***************************************************************/
    
    
    //Write the didUpdateLocations method here:
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let location = locations[locations.count - 1]
        if location.horizontalAccuracy > 0 {
            locationManager.stopUpdatingLocation()
            locationManager.delegate = nil
            let lat = String(location.coordinate.latitude)
            let long = String(location.coordinate.longitude)
            let params : [String : String] = ["lat" : lat, "lon" : long, "appid" : APP_ID]
            
            getWeatherData(url : WEATHER_URL, parameters : params)
        }
    }
    
    //Write the didFailWithError method here:
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        cityLabel.text = "Location Unavailable"
    }
    
    //MARK: - Change City Delegate methods
    /***************************************************************/
    
    @IBAction func changeCity(_ sender: UIButton) {
        performSegue(withIdentifier: "changeCityName", sender: self)
    }
    
    //Write the userEnteredANewCityName Delegate method here:
    func userEnteredANewCityName(city: String) {
        let params : [String:String] = ["q" : city, "appid" : APP_ID]
        getWeatherData(url : WEATHER_URL, parameters: params)
    }

    //Write the PrepareForSegue Method here
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "changeCityName" {
            let destinationVC = segue.destination as! ChangeCityViewController
            destinationVC.delegate = self
        }
    }
    
}


