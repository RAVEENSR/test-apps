/*
 * Copyright 2011-2012 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.jaxrs.server;

import java.util.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.wso2.carbon.apimgt.api.APIProvider;
import org.wso2.carbon.apimgt.api.model.*;
import org.wso2.carbon.apimgt.impl.APIManagerFactory;

@Path("/")
public class APIService {
    APIProvider provider;

    public APIService() {
        try {
            provider = APIManagerFactory.getInstance().getAPIProvider("admin");
        } catch (Exception e) {
            System.out.println("Error while initializing API provider");
        }
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAPI(@PathParam("id") String id) {
        System.out.println("API Service -- invoking getAPI, API id is: " + id);
        try{
        long idNumber = Long.parseLong(id);
        List<API> apiList = provider.getAllAPIs();
        StringBuffer sb = new StringBuffer();
        Iterator<API> iterator =  apiList.iterator();
            while (iterator.hasNext()){
                sb.append(iterator.next().getId());
            }
           return Response.ok(sb.toString()).build();
           // return Response.ok(apiList).build();
        }
        catch (Exception e){
            return null;
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAPI(API api) {
        try {
            provider.addAPI(api);
        } catch (Exception e) {
            System.out.print("Error while adding API");
        }
        return Response.ok(api).build();
    }

}