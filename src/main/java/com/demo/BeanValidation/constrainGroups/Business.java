package com.demo.BeanValidation.constrainGroups;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

//constraint for a business man
@GroupSequence({Default.class,common.class})
public interface Business{
}