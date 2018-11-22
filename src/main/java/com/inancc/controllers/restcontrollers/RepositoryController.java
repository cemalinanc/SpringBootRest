package com.inancc.controllers.restcontrollers;

import com.inancc.models.IRepository;
import com.inancc.services.IRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("repositories")
public class RepositoryController {

    @Autowired
    private IRepositoryService repositoryService ;


    @RequestMapping(value="/{owner}/{repository-name}", method = RequestMethod.GET)
    public IRepository repositoryInformation(@PathVariable("owner") String ownerName, @PathVariable("repository-name") String repoName){

        return repositoryService.getRepositoryInformation(ownerName, repoName);

    }





}
