/*
 *  Copyright (C) 2018 Raffaele Conforti (www.raffaeleconforti.com)
 *
 *  This project is dual licensed under GNU Affero General Public License and Raffaele Conforti License.
 *  You can choose between one of them if you use this work
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a
 *  copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included
 *  in all copies or substantial portions of the Software.
 *
 *  When this software (or parts of it) is being used in a website or
 *  application, the message "Process Discover - raffaeleconforti.com"
 *  must stay fully visible to the user and not visually overlapped by other elements.
 *  The message must be showed using a 12 point font size minimum and must
 *  appear on the screen for the entire duration of the usage and a minimum of 30
 *  seconds.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 *  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 */

package com.raffaeleconforti.processdiscoverer.impl.filter;

import com.raffaeleconforti.processdiscoverer.LogFilterCriterion;
import com.raffaeleconforti.processdiscoverer.impl.filter.impl.LogFilterCriterionAttribute;
import com.raffaeleconforti.processdiscoverer.impl.filter.impl.LogFilterCriterionDirectFollow;
import com.raffaeleconforti.processdiscoverer.impl.filter.impl.LogFilterCriterionDuration;
import com.raffaeleconforti.processdiscoverer.impl.filter.impl.LogFilterCriterionEventuallyFollow;

import java.util.Set;

public class LogFilterCriterionFactory {

    public static LogFilterCriterion getLogFilterCriterion(Action action, Containment containment, Level level, String label, String attribute, Set<String> value) {
        switch (LogFilterTypeSelector.getType(attribute)) {
            case 1:
                return new LogFilterCriterionDirectFollow(action, containment, level, label, attribute, value);
            case 2:
                return new LogFilterCriterionEventuallyFollow(action, containment, level, label, attribute, value);
            case 7:
                return new LogFilterCriterionDuration(action, containment, level, label, attribute, value);
            default:
                return new LogFilterCriterionAttribute(action, containment, level, label, attribute, value);
        }
    }

}
