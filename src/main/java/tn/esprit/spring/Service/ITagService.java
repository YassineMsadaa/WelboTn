package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.Entity.Tag;


import java.util.List;

public interface ITagService {
    public Tag ajouterTag(Tag tag);
    public void deleteTag(Long tagId);
    public List<Tag> getTags();
    public Tag modifierTag(Tag tag);
    public Tag getTag(Long tagId);
    public List<Tag> addTagsToPost (Long NewsfeedPostId, List<Tag> tagRequest);
}
