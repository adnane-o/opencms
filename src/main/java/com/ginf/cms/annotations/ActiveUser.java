package com.ginf.cms.annotations;

import java.lang.annotation.*;

/**
 * Created by Adnane on 10/02/2015.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActiveUser {
}