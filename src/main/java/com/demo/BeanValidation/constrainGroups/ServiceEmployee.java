package com.demo.BeanValidation.constrainGroups;

import org.graalvm.compiler.nodes.NodeView;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class,common.class})
public interface ServiceEmployee {
}
