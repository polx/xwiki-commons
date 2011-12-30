/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.extension.unmodifiable;

import org.xwiki.extension.Extension;
import org.xwiki.extension.LocalExtension;
import org.xwiki.extension.job.plan.ExtensionPlanAction;
import org.xwiki.extension.version.VersionConstraint;

/**
 * Provide a readonly access to an extension plan action.
 * 
 * @version $Id$
 */
public class UnmodifiableExtensionPlanAction implements ExtensionPlanAction
{
    /**
     * The wrapped action.
     */
    private ExtensionPlanAction wrappedAction;

    /**
     * @param action the wrapped action
     */
    public UnmodifiableExtensionPlanAction(ExtensionPlanAction action)
    {
        this.wrappedAction = action;
    }

    @Override
    public Extension getExtension()
    {
        return UnmodifiableUtils.unmodifiableExtension(this.wrappedAction.getExtension());
    }

    @Override
    public LocalExtension getPreviousExtension()
    {
        return UnmodifiableUtils.unmodifiableExtension(this.wrappedAction.getPreviousExtension());
    }

    @Override
    public Action getAction()
    {
        return this.wrappedAction.getAction();
    }

    @Override
    public String getNamespace()
    {
        return this.wrappedAction.getNamespace();
    }

    @Override
    public VersionConstraint getVersionConstraint()
    {
        return this.wrappedAction.getVersionConstraint();
    }

    // Object

    @Override
    public int hashCode()
    {
        return this.wrappedAction.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return this.wrappedAction.equals(obj);
    }

    @Override
    public String toString()
    {
        return this.wrappedAction.toString();
    }
}
