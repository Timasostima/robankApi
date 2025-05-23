package dev.tymurkulivar.robank_backend.dto;

import dev.tymurkulivar.robank_backend.entities.Preferences;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreferencesDTO {
    private Long id;
    private String theme;
    private String currency;
    private String language;
    private boolean notifications;

    public PreferencesDTO(Preferences preferences) {
        this.id = preferences.getId();
        this.language = preferences.getLanguage();
        this.currency = preferences.getCurrency();
        this.theme = preferences.getTheme();
        this.notifications = preferences.getNotifications();
    }
}
