package dev.tymurkulivar.robank_backend.services;

import dev.tymurkulivar.robank_backend.dto.CategoryDTO;
import dev.tymurkulivar.robank_backend.entities.Category;
import dev.tymurkulivar.robank_backend.entities.RobankUser;
import dev.tymurkulivar.robank_backend.repositories.CategoryRepository;
import dev.tymurkulivar.robank_backend.repositories.RobankUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final RobankUserRepository userRepository;

    public CategoryService(CategoryRepository categoryRepository, RobankUserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public List<CategoryDTO> getCategories(String userUid) {
        List<Category> categories = categoryRepository.findAllByUserUid(userUid);
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOs.add(new CategoryDTO(category));
        }
        return categoryDTOs;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO, String userId) {
        RobankUser user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Category category = new Category(categoryDTO);
        category.setUser(user);
        categoryRepository.save(category);
        return new CategoryDTO(category);
    }
}
