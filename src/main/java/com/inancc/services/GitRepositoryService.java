package com.inancc.services;

import com.inancc.models.GitRepository;
import com.inancc.models.IRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class GitRepositoryService implements IRepositoryService {


    private static final String BASE_GIT_INFO_SERVICE_URL = "https://api.github.com/repos/";
    private static final Logger logger = LogManager.getLogger(GitRepositoryService.class);

    /*
    Git api to use : http://api.github.com/repos/[username]/[reponame]
     */
    @Override
    public IRepository getRepositoryInformation(final String ownerName, final String repoName) {

        final String fullServiceUrl = BASE_GIT_INFO_SERVICE_URL + ownerName + "/" + repoName;
        RestTemplate restTemplate = new RestTemplate();

        IRepository repository = restTemplate.getForObject(fullServiceUrl, GitRepository.class);

        if(repository == null)
        {
            logger.info("Nothing is retrieved from: "+ fullServiceUrl);
            //do some other stuff if necessery
        }

        return repository;

    }


}
