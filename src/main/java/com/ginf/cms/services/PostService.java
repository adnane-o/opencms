package com.ginf.cms.services;

import com.ginf.cms.entities.Post;
import com.ginf.cms.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Adnane on 10/02/2015.
 */
@Service("postService")
public class PostService implements IPostService {
    private static final int PAGE_SIZE = 10;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private ICategoryService categoryService;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findOne(Integer id) {
        return postRepository.findOne(id);
    }

    @Override
    public Page<Post> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return postRepository.findAll(request);
    }

    @Override
    public Page<Post> findAllNew(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        Page<Post> posts = postRepository.findAllByNewVersion(null, request);
        posts.getContent().removeIf(p -> p.getNewVersion() != null);
        return posts;
    }

    @Override
    public Page<Post> findAllPublic(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        Page<Post> posts = postRepository.findAllByPublishedAndNewVersion(true, null, request);
        return posts;
    }

    @Override
    public Post update(Post post) throws Exception {
        Post postToUpdate = postRepository.findOne(post.getId());

        if (postToUpdate == null) {
            throw new Exception("Requested post does not exit");
        }

        if (postToUpdate.isDifferentFrom(post)) {
            Post oldPost = post.getClass().newInstance();
            oldPost.copyFrom(postToUpdate);
            oldPost.setNewVersion(postToUpdate);
            oldPost.setPublished(false);
            postRepository.save(oldPost);
        }


        postToUpdate.copyFrom(post);
        postToUpdate.setAttachments(post.getAttachments());
        postToUpdate.setCategories(post.getCategories());
        postToUpdate.setNewVersion(null);
        postRepository.save(postToUpdate);

        return postToUpdate;
    }

    @Override
    public Post restore(Post post) throws Exception {
        if (post.getNewVersion() == null)
            throw new Exception("This the new version");

        Post currentPost = post.getNewVersion();
        post.setId(currentPost.getId());

        return update(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
