package com.digitalcrafts.syntel.controller;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherLookupController {

    @RequestMapping("/weatherlookup")
    public Object productLookup(@RequestParam(value="city", required=true, defaultValue = "Atlanta") String queryCity) throws APIException {
        final String OWM_APIKEY = System.getenv().get("OWMAPI");
        OWM owm = new OWM(OWM_APIKEY);
        CurrentWeather cwd = owm.currentWeatherByCityName(queryCity) ;
        return cwd;
    }
}
