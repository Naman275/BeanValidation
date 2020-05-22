package com.demo.BeanValidation.constrainGroups;

import javax.validation.groups.Default;

/*
mandatory common constaints
if any constraint belonging to this group fails more validation should not be performed.
Make sure to extend Default also otherwise Default validation will not work
 */
public interface common extends Default {
}
