//package com.manywho.sdk.services.controllers;
//
//import com.fasterxml.jackson.databind.node.TextNode;
//import com.manywho.sdk.api.run.elements.config.SocialServiceRequest;
//import com.manywho.sdk.api.social.MentionedWho;
//import com.manywho.sdk.api.social.Message;
//import com.manywho.sdk.api.social.MessageList;
//import com.manywho.sdk.api.social.Who;
//import com.manywho.sdk.services.validation.social.CreateStream;
//import com.manywho.sdk.services.validation.social.DeleteMessage;
//import com.manywho.sdk.services.validation.social.FollowStream;
//import com.manywho.sdk.services.validation.social.GetCurrentUser;
//import com.manywho.sdk.services.validation.social.GetStreamFollowers;
//import com.manywho.sdk.services.validation.social.GetStreamMessages;
//import com.manywho.sdk.services.validation.social.GetUser;
//import com.manywho.sdk.services.validation.social.LikeMessage;
//import com.manywho.sdk.services.validation.social.PostNewMessage;
//import com.manywho.sdk.services.validation.social.SearchUsersByName;
//import com.manywho.sdk.services.validation.social.ShareMessage;
//import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
//import org.glassfish.jersey.media.multipart.FormDataParam;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.io.InputStream;
//import java.util.List;
//import java.util.UUID;
//
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//public abstract class AbstractSocialController {
//
//    @Path("/social/stream")
//    @POST
//    public abstract TextNode createStream(@CreateStream SocialServiceRequest serviceRequest) throws Exception;
//
//    @Path("/social/stream/{id}/message/{messageId}")
//    @POST
//    public abstract TextNode deleteMessage(@DeleteMessage SocialServiceRequest serviceRequest,
//                                           @PathParam("id") UUID streamId,
//                                           @PathParam("messageId") UUID messageId)
//            throws Exception;
//
//    @Path("/social/stream/{id}/follow/{follow}")
//    @POST
//    public abstract TextNode followStream(@FollowStream SocialServiceRequest serviceRequest,
//                                          @PathParam("id") UUID streamId,
//                                          @PathParam("follow") boolean follow)
//            throws Exception;
//
//    @Path("/social/stream/{id}/user/me")
//    @POST
//    public abstract Who getCurrentUser(@GetCurrentUser SocialServiceRequest serviceRequest,
//                                       @PathParam("id") UUID streamId)
//            throws Exception;
//
//    @Path("/social/stream/{id}/follower")
//    @POST
//    public abstract List<Who> getStreamFollowers(@GetStreamFollowers SocialServiceRequest serviceRequest,
//                                                 @PathParam("id") UUID streamId)
//            throws Exception;
//
//    @Path("/social/stream/{id}")
//    @POST
//    public abstract MessageList getStreamMessages(@GetStreamMessages SocialServiceRequest serviceRequest,
//                                                  @PathParam("id") UUID streamId)
//            throws Exception;
//
//    @Path("/social/stream/{id}/user/{userId}")
//    @POST
//    public abstract Who getUser(@GetUser SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId,
//                                @PathParam("userId") String userId)
//            throws Exception;
//
//    @Path("/social/stream/{id}/message/{messageId}/like/{like}")
//    @POST
//    public abstract TextNode likeMessage(@LikeMessage SocialServiceRequest serviceRequest,
//                                         @PathParam("id") UUID streamId,
//                                         @PathParam("messageId") UUID messageId,
//                                         @PathParam("like") boolean like)
//            throws Exception;
//
//    @Path("/social/stream/{id}/message")
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public abstract Message postNewMessage(@PostNewMessage @FormDataParam("serviceRequest") SocialServiceRequest serviceRequest,
//                                           @FormDataParam("file") InputStream file,
//                                           @FormDataParam("file") FormDataContentDisposition fileDetails,
//                                           @PathParam("id") UUID streamId) throws Exception;
//
//    @Path("/social/stream/{id}/user/name/{name}")
//    @POST
//    public abstract List<MentionedWho> searchUsersByName(@SearchUsersByName SocialServiceRequest serviceRequest,
//                                                         @PathParam("id") UUID streamId,
//                                                         @PathParam("name") String name)
//            throws Exception;
//
//    @Path("/social/stream/{id}/share")
//    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public abstract Message shareMessage(@ShareMessage @FormDataParam("serviceRequest") SocialServiceRequest serviceRequest,
//                                         @PathParam("id") UUID streamId) throws Exception;
//}
