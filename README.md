# konnekt
Making contact sharing easy

Every year thousands of people attends various conferences across the world. But to connect with each other they still use the same old business cards in this digital age. These cards gets lost and we might loose an important contact. Let's digitalize this. A simple QRCode based contact sharing utility. "Konnekt".

Idea: 
- Attendees(speakers, participants, etc) can create profile and add personal details and social media account links.
  - first_name
  - last_name
  - website 
  - mobile
  - designation
  - organization
  - linkedin
  - github, 
  - facebook
  - twitter
  - bio(one-liner)

These details will be stored in centralized server with unique key. Each key represent a uniqe url which returns these details in json format on get request

- A QR code will be generated for each profile, displayed on profile page (Can be printed on event badges)

- On scanning this QRCode, contact will be added in your contact list

- You can save additional notes about contact (How did you meet, what did you talk about, follow-up required etc.)
