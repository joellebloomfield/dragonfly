package com.ge.predix.labs.data.jpa.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ge.predix.labs.data.jpa.domain.Location;
import com.ge.predix.labs.data.jpa.service.LocationService;

@ComponentScan
@RestController
public class LocationApiController {

    @Autowired  private LocationService locationService;

    public static final String LOCATION = "/locations";
    public static final String GET_LOCATION_BY_ID = LOCATION + "/{id}";
    public static final String GET_LOCATION_BY_DEVICE_ID = LOCATION + "/device/{id}";
	private static final String LAST_LOCATIONS = LOCATION + "/last";

    @RequestMapping(value = LAST_LOCATIONS, method = RequestMethod.GET)
    public Collection<Location> getLastEvent() throws Exception {
        Collection<Location> locations = locationService.getLastEvent();
        for (Location location: locations) System.out.println(location.getId());
        return locations;
    }

    @RequestMapping(value = GET_LOCATION_BY_ID, method = RequestMethod.GET)
    public Location locationById(@PathVariable  Long id) {
        return this.locationService.getLocationById(id);
    }
    
    @RequestMapping(value = GET_LOCATION_BY_DEVICE_ID , method = RequestMethod.GET)
    public Collection<Location> locationByDeviceId(@PathVariable  Long id) {
    	return locationService.getLocationsByDeviceId(id);
    }

    @RequestMapping(value = LOCATION, method = RequestMethod.GET)
    public Collection<Location> locations() throws Exception {
        Collection<Location> locations = locationService.getAllLocations();
        return locations;
    }

    @RequestMapping(value = LOCATION, method = RequestMethod.POST)
    public Long addLocation(@RequestBody Location location) {
        return locationService.createLocation(location).getId();
    }
}