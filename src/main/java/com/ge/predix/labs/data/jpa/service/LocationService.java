package com.ge.predix.labs.data.jpa.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.predix.labs.data.jpa.domain.Location;

@Service
@SuppressWarnings("unchecked")
@Transactional
public class LocationService {

    public static final String LOCATIONS = "locations";

    @PersistenceContext
    private EntityManager em;

    public Location createLocation(Location location) {
        em.persist(location);
        return location;
    }

    public Collection<Location> getLocationsByDeviceId(Long id) {
        String sql = "select c.* from Location c where (c.deviceId = " + id + ")";
        return em.createNativeQuery(sql, Location.class)
                .getResultList();
    }
    
    @Transactional(readOnly = true)
    public  List<Location> getLastEvent() {
    	return em.createQuery("FROM Location c WHERE c.id IN (SELECT max(cc.id) FROM Location cc GROUP BY deviceid)").getResultList();
    }

    @Transactional(readOnly = true)
    public List<Location> getAllLocations() {
        return em.createQuery("FROM Location").getResultList();
    }
    
    @Cacheable(LOCATIONS)
    @Transactional(readOnly = true)
    public Location getLocationById(Long id) {
        return em.find(Location.class, id);
    }

    @CacheEvict(LOCATIONS)
    public void deleteCustomer(Long id) {
    	Location location = getLocationById(id);
        em.remove(location);
    }
}
