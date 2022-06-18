package com.yejf.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * film
 * @author 
 */
@Data
public class Film implements Serializable {
    private Short filmId;

    private String title;

    private String description;

    private Object releaseYear;

    private Byte languageId;

    private Byte originalLanguageId;

    private Byte rentalDuration;

    private BigDecimal rentalRate;

    private Short length;

    private BigDecimal replacementCost;

    private Object rating;

    private Object specialFeatures;

    private Date lastUpdate;

    private static final long serialVersionUID = 1L;
}