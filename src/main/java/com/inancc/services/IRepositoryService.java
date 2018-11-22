package com.inancc.services;

import com.inancc.models.IRepository;

public interface IRepositoryService {

     IRepository getRepositoryInformation(final String ownerName, final String repoName);
}
