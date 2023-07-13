package com.faith.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.faith.app.entity.LabTest;
import com.faith.app.service.ILabTestService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabTestController {

    @Autowired
    private ILabTestService labtestservice;

    @GetMapping("/labtests")
    public List<LabTest> getAllLabTests() {
        return labtestservice.getListTest();
    }

    @PostMapping("/labtests")
    public LabTest addLabTest(@RequestBody LabTest labtest) {
        labtestservice.saveLabTest(labtest);
        return labtest;
    }

  //update Tests
    @PutMapping("/labtests")
    public void updateTests(@RequestBody LabTest labtest) {
    	labtestservice.saveLabTest(labtest);
    }

    //delete test
    @DeleteMapping("/test/{id}")
    public void deleteTest(@PathVariable int id) {
    labtestservice.disableLabTest(id);

    }

    //search test by name
    @GetMapping("/test/search/{name}")
    public List<LabTest>getAllTestByName(@PathVariable String name){
    return labtestservice.getLabTestByName(name);
    }
    
    @GetMapping("/tests/{labTestId}")
	public LabTest listTestById(@PathVariable int labTestId){
		return labtestservice.getLabTest(labTestId);
	}
}