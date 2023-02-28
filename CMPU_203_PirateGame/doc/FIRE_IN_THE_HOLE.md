### Random to dos/reminders
<li>Add vironium to glossary </li>
<li>Pause screen, map, inventory, health button must always be accessible, even when story card is up</li>

### Doubt Meter
<p>Things like peeking at the diary and interrogating locals about the grove will
drive up the user's doubt meter (e.g. their level of suspicion about the true nature
of the mission). There will be subtle hints throughout scenes 1-6. 

At that point, if their doubt is high enough, they receive alternate versions of scenes 
7-9 wherein they learn more about the shady client, the recent conquering of Helion, and the 
potential value of the Vironium (all these clues are unrelated so that if later on,
they only see a few, they still make sense). 

In the non-alternate timeline, there is one more opportunity to increase the doubt meter.
At the end, if the doubt meter is above 0, they have a choice whether to send in the letter.
Otherwise, it gets sent automatically.</p>

### Stuff to figure out
<ul>
<li>Make move knows whether we're at an island, but all it does if we are is print story cards, 
and we want it to trigger a scanner multiple choice moment </li>
<li>Make it so the last island ends the game lol this is important</li>
</ul>


UI class has a generic A B scanner method to be used AFTER you've already asked the user something

if make move result, which is stored in res, contains a ? then after printing res, the UI does
its A B scanner class method


Eventually, ideally, they get some resolution to the choice they made